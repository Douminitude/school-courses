<template>
  <div class="week">
    <div class="week-semaine-container">
      <div class="week-semaine-titre-container" @click="foldMe(week.id)">
        <h5 class="week-semaine">{{ week.semaine }}</h5>
      </div>
      <div class="week-semaine-icons">
        <button class="editWeekButton" @click="onEdit(week)">
          <i class="material-icons">edit</i>
        </button>
        <button class="deleteWeekButton" @dblclick="deleteWeek(week.id)">
          <i class="material-icons">delete</i>
        </button>
      </div>
    </div>
    <div v-show="!week.folded" class="week-text">
      <div class="week-info week-text-child">
        <h6 class="week-subject">{{ week.subject }}</h6>
        <a
          :key="doc.fileNameBack"
          v-for="doc in week.docs"
          class="week-doc"
          :href="'./' + week.cours + '/' + doc.fileNameBack"
          target="_blank"
          >{{ doc.fileNameFront }}<br
        /></a>
      </div>
      <div class="week-todo week-text-child">
        <button class="addTaskButton" @click="toggleTaskForm">
          <i class="material-icons">add_circle</i>
        </button>
        <form
          class="taskForm"
          v-show="addTask"
          @submit.prevent="newTask(this.week)"
        >
          <input
            ref="taskInput"
            id="taskInput"
            class="form-control"
            type="text"
            v-model="taskName"
            name="taskName"
          />
        </form>
        <div :style="{ top: topTasks + 'px' }" class="tasks" id="tasks">
          <Tasks :tasks="week.tasks" @checkMe="checkMe" />
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import Tasks from "./Tasks.vue";

export default {
  name: "Week",
  components: {
    Tasks,
  },
  data() {
    return {
      addTask: false,
      topTasks: 5,
    };
  },
  props: {
    week: Object,
  },
  methods: {
    toggleTaskForm() {
      if (!this.addTask) {
        this.topTasks = 35;
      } else {
        this.topTasks = 5;
      }
      this.addTask = !this.addTask;
      this.$nextTick(() => this.$refs.taskInput.focus());
    },
    newTask(week) {
      let newTask = {
        id: Math.floor(Math.random() * 100000),
        taskName: this.taskName,
        taskDone: false,
      };
      this.$emit("newTask", week, newTask);
      this.toggleTaskForm();
      this.taskName = "";
    },
    async checkMe(task) {
      let id = this.week.id;

      const res = await fetch(`api/weeks/${id}`);
      const data = await res.json();

      let index = data.tasks.findIndex(
        (item) => item.taskName === task.taskName
      );
      data.tasks[index].taskDone = !task.taskDone;
      let updatedTasks = data.tasks;

      this.$emit("checkMe", updatedTasks, this.week);
    },
    deleteWeek(id) {
      this.$emit("deleteWeek", id);
    },
    onEdit(week) {
      this.$emit("onEdit", week);
    },
    async foldMe(id) {
      let updateFold = {
        cours: this.week.cours,
        semaine: this.week.semaine,
        subject: this.week.subject,
        docs: this.week.docs,
        fileNames: this.week.fileNames,
        folded: !this.week.folded,
        tasks: this.week.tasks,
      };

      await fetch(`api/weeks/${id}`, {
        method: "PUT",
        headers: {
          "Content-type": "application/json",
        },
        body: JSON.stringify(updateFold),
      });

      this.$emit("refresh");
    },
  },
};
</script>

<style>
.week {
  position: relative;
  display: block;
  margin-bottom: 20px;
}
.week-semaine-container {
  box-sizing: border-box;
  border-bottom: solid 1px #747474;
  cursor: pointer;
  display: flex;
  justify-content: space-between;
  height: 33px;
  transition: border 0.1s ease-in;
}
.week-semaine-container:hover {
  box-sizing: border-box;
  border-bottom: solid 2px #1d00db;
}
.week-semaine-titre-container {
  display: inline-block;
  width: 92%;
}
.week-semaine {
  color: #1f2833;
  display: inline-block;
  position: relative;
  margin: 0;
}
.week-semaine-icons {
  display: inline-block;
  position: relative;
  width: 8%;
  padding-top: 3px;
  text-align: right;
}
.week-text {
  display: flex;
  position: relative;
  justify-content: space-between;
}
.week-text-child {
  display: inline-block;
  position: relative;
}
.week-subject {
  color: #747474;
  white-space: pre-wrap;
}
.week-info {
  width: 70%;
  margin-top: 10px;
}
.week-todo {
  width: 30%;
}
.week-doc {
  color: #1d00db;
}
.editWeekButton {
  position: absolute;
  right: 45px;
  font-size: 1.5rem;
  height: 24px;
  width: 24px;
  z-index: 4;
}
.editWeekButton:hover {
  color: #00cfd3;
}
.deleteWeekButton {
  position: absolute;
  right: 7px;
  font-size: 1.5rem;
  height: 24px;
  width: 24px;
  z-index: 4;
}
.deleteWeekButton:hover {
  color: #b00020;
}
#tasks {
  background-color: white;
  text-align: right;
  position: relative;
  display: block;
  width: 100%;
  right: 50px;
}
.taskForm {
  position: absolute;
  display: inline-block;
  top: 0;
  right: 45px;
}
.addTaskButton {
  position: absolute;
  top: 5px;
  right: 7px;
  font-size: 1.5rem;
  height: 24px;
  width: 24px;
  z-index: 4;
}
.addTaskButton:hover {
  color: #1d00db;
}
#taskInput {
  display: block;
  width: 300px;
  height: 24px;
  margin-top: 5px;
}
</style>
