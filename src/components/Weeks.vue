<template>
  <div class="weeks">
    <button class="addWeekButton" @click="toggleModal">
      <i class="material-icons" id="addWeekButton">add_circle</i>
    </button>
    <transition name="fade">
      <Modal
        v-if="isModalVisible"
        :week="week"
        :coursIft="coursInfo"
        @addWeek="addWeek"
        @updateWeek="updateWeek"
        @toggleModal="toggleModal"
      >
      </Modal>
    </transition>
    <Week
      v-for="week in weeks"
      :key="week.id"
      :week="week"
      @refresh="refresh"
      @onEdit="editWeek"
      @deleteWeek="deleteWeek"
      @newTask="newTask"
      @checkMe="checkMe"
    >
    </Week>
  </div>
</template>

<script>
import Week from "./Week.vue";
import Modal from "./Modal.vue";

export default {
  name: "Weeks",
  components: {
    Week,
    Modal,
  },
  props: {
    coursInfo: String,
  },
  data() {
    return {
      weeks: [],
      isModalVisible: false,
      week: {},
    };
  },
  async created() {
    this.weeks = await this.fetchWeeks();
    this.$emit("amReady");
  },
  methods: {
    checkMe(updatedTasks, week) {
      let id = week.id;
      let updateTasks = {
        cours: week.cours,
        semaine: week.semaine,
        subject: week.subject,
        docs: week.docs,
        fileNames: week.fileNames,
        folded: week.folded,
        tasks: updatedTasks,
      };

      this.PUTmethod(updateTasks, id);
    },
    newTask(week, newTask) {
      week.tasks.push(newTask);

      let id = week.id;
      let updateWeek = {
        cours: week.cours,
        semaine: week.semaine,
        subject: week.subject,
        docs: week.docs,
        fileNames: week.fileNames,
        folded: false,
        tasks: week.tasks,
      };

      this.PUTmethod(updateWeek, id);
    },
    editWeek(week) {
      this.week = week;
      this.isModalVisible = true;
    },
    toggleModal() {
      if (this.isModalVisible == true) {
        this.week = {};
        this.isModalVisible = false;
        // setTimeout(function(){ this.isModalVisible = false; }, 3000);
        // setTimeout(function(){ alert("Hello"); }, 2000);
      } else {
        this.isModalVisible = true;
      }
    },
    addWeek(week) {
      const data = this.POSTmethod(week);
      this.weeks = [...this.weeks, data];

      this.refresh();
      this.toggleModal();
    },
    updateWeek(editWeek) {
      let id = editWeek.id;
      let updateWeek = {
        cours: editWeek.cours,
        semaine: editWeek.semaine,
        subject: editWeek.subject,
        docs: editWeek.docs,
        fileNames: editWeek.fileNames,
        folded: false,
        tasks: editWeek.tasks,
      };

      this.PUTmethod(updateWeek, id);
      this.toggleModal();
    },
    async refresh() {
      this.weeks = await this.fetchWeeks();
    },
    async PUTmethod(thingToPUT, id) {
      await fetch(`api/weeks/${id}`, {
        method: "PUT",
        headers: {
          "Content-type": "application/json",
        },
        body: JSON.stringify(thingToPUT),
      });

      this.refresh();
    },
    async POSTmethod(thingToPOST) {
      const res = await fetch("api/weeks", {
        method: "POST",
        headers: {
          "Content-type": "application/json",
        },
        body: JSON.stringify(thingToPOST),
      });
      const data = await res.json();

      return data;
    },
    async deleteWeek(id) {
      const res = await fetch(`api/weeks/${id}`, { method: "DELETE" });

      res.status === 200
        ? (this.weeks = this.weeks.filter((week) => week.id !== id))
        : alert("Won't delete, sorry :(");
    },
    async fetchWeeks() {
      const res = await fetch("api/weeks");
      const data = await res.json();
      const filteredData = data.filter((item) => item.cours === this.coursInfo);

      return filteredData;
    },
    async fetchWeek(id) {
      const res = await fetch(`api/weeks/${id}`);
      const data = await res.json();

      return data;
    },
  },
};
</script>

<style>
.fade-enter-active,
.fade-leave-active {
  transition: opacity 0.1s linear;
}
.fade-enter-from,
.fade-leave-to {
  opacity: 0;
}
.fade-enter-to,
.fade-leave-from {
  opacity: 1;
}
.weeks {
  display: block;
  position: relative;
  width: 100%;
  padding: 0 50px;
  text-align: left;
  background-color: white;
}
.addWeekButton {
  position: fixed;
  height: 50px;
  width: 50px;
  bottom: 40px;
  right: 40px;
  padding: 0;
  z-index: 5;
  border: none;
  color: #1d00db;
  border-radius: 100px;
  vertical-align: middle;
  background-color: white;
  transition: background-color 0.3s ease;
  box-shadow: 0px 3px 5px -1px rgba(0, 0, 0, 0.2),
    0px 6px 10px 0px rgba(0, 0, 0, 0.14), 0px 1px 18px 0px rgba(0, 0, 0, 0.12);
}
#addWeekButton {
  max-height: 0;
  max-width: 0;
  border: none;
  font-size: 60px;
  border-radius: 100px;
  background-color: transparent;
  transform: translate(-55px, -5px);
}
#addWeekButton:hover {
  background-color: #f5f5f5;
}
</style>
