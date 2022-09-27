<template>
  <div class="header">
    <Tabs :tabs="tabs" />
  </div>
</template>

<script>
import Tabs from "./Tabs.vue";

export default {
  components: {
    Tabs,
  },
  props: {
    cours: String,
  },
  data() {
    return {
      tabs: [],
    };
  },
  created() {
    this.tabs = [
      {
        id: 1,
        fullname: "Structures de données",
        shortname: "IFT2015",
        path: "/IFT2015",
      },
      {
        id: 2,
        fullname: "Concepts de langages de programmation",
        shortname: "IFT2035",
        path: "/IFT2035",
      },
      {
        id: 3,
        fullname: "Introduction à l'informatique théorique",
        shortname: "IFT2105",
        path: "/IFT2105",
      },
      {
        id: 4,
        fullname: "Génie logiciel",
        shortname: "IFT2255",
        path: "/IFT2255",
      },
    ];
  },
};
</script>

<style>
.header {
  display: flex;
  position: relative;
  top: 0;
  height: 60px;
  width: 100%;
  flex-wrap: wrap;
  padding-left: 0;
  margin-bottom: 0;
  z-index: 5;
  background-color: rgba(29, 0, 219, 1);
  box-shadow: 0 2px 4px rgba(0, 0, 0, 0.5);
}
.header .nav-tab-link {
  height: 100%;
  font-family: "Montserrat";
  font-size: 33px;
}
</style>
