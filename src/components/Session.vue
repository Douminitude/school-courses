<template>
  <div class="session">
    <h4>{{ coursSpecs.coursNom }}</h4>
    <div class="comp weeksComp">
      <Weeks :coursInfo="coursSpecs.cours" @amReady="weeksReady" />
    </div>
    <div class="comp travauxComp" v-show="isReady">
      <Travaux :travaux="travaux" />
    </div>
    <div class="comp ressourcesComp" v-show="isReady">
      <Ressources :ressources="ressources" />
    </div>
  </div>
</template>

<script>
import Weeks from "./Weeks.vue";
import Travaux from "./Travaux.vue";
import Ressources from "./Ressources.vue";

export default {
  name: "Session",
  components: {
    Weeks,
    Travaux,
    Ressources,
  },
  props: {
    coursSpecs: Object,
    travaux: Array,
    ressources: Array,
  },
  data() {
    return {
      isReady: false,
    };
  },
  methods: {
    weeksReady() {
      this.isReady = true;
    },
  },
};
</script>

<style>
.session {
  display: block;
  position: relative;
  min-height: 100vh;
  padding-top: 30px;
  background-color: white;
}
.comp {
  display: block;
  position: relative;
  padding-top: 30px;
}
.modal-fade-enter,
.modal-fade-leave-to {
  opacity: 0;
}
.modal-fade-leave,
.modal-fade-enter-to {
  opacity: 0.95;
}
.modal-fade-enter-active,
.modal-fade-leave-active {
  transition: opacity 0.3s ease;
}
</style>
