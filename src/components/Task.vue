<template>
  <label class="taskLabel" :for="task.id">{{ task.taskName }}</label>
  <input
    class="taskCheckbox"
    type="checkbox"
    value=""
    @click="checkMe(task)"
    v-model="taskDone"
    :id="task.id"
    :checked="task.taskDone"
  />
</template>

<script>
export default {
  name: "Task",
  props: {
    task: Object,
  },
  methods: {
    checkMe(task) {
      this.$emit("checkMe", task);
    },
  },
};
</script>

<style>
.taskLabel {
  display: inline-block;
  padding-right: 1.75em;
  font-family: "RobotoMono";
}
.taskCheckbox {
  display: inline-block;
  position: absolute;
  height: 1em;
  width: 1em;
  right: 0;
  margin-top: 0.25em;
  vertical-align: top;
  border-radius: 0.25em;
  -webkit-appearance: none;
  border: 1px solid rgba(0, 0, 0, 0.25);
}
.taskCheckbox:focus {
  border-color: #86b7fe;
  box-shadow: 0 0 0 0.15rem rgba(13, 110, 253, 0.25);
}
.taskCheckbox:checked {
  background-color: #0d6efd;
  border-color: #0d6efd;
  background-image: url("data:image/svg+xml,%3csvg xmlns='http://www.w3.org/2000/svg' viewBox='0 0 20 20'%3e%3cpath fill='none' stroke='%23fff' stroke-linecap='round' stroke-linejoin='round' stroke-width='3' d='M6 10l3 3l6-6'/%3e%3c/svg%3e");
}
</style>
