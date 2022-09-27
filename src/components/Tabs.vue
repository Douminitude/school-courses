<template>
  <div class="nav-tab" :key="tab.id" v-for="tab in tabs">
    <Tab :tab="tab" />
  </div>
</template>

<script>
import Tab from "./Tab.vue";

export default {
  name: "Tabs",
  components: {
    Tab,
  },
  props: {
    tabs: Array,
  },
};
</script>

<style>
.nav-tab {
  display: inline-block;
  width: 25%;
  transition: background-color 0.15s ease-in-out;
}
.nav-tab:hover {
  background-color: #0000a8;
}
.nav-tab a {
  color: white;
}
</style>
