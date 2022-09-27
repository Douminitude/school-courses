<template>
  <transition name="fade" @after-leave="toggleModal">
    <div class="modal-back" @click="toggleModal">
      <div class="modal-front" @click.stop="">
        <header class="modal-header" id="modalTitle">
          <h4 class="modal-title">Ajout d'une semaine!</h4>
          <button type="button" class="closeModalButton" @click="toggleModal">
            <i class="material-icons" style="font-size: 32px">cancel</i>
          </button>
        </header>
        <section class="modal-body" id="modalDescription">
          <FormWeek
            :week="week"
            @addWeek="addWeek"
            @updateWeek="updateWeek"
            :coursIFT="coursIft"
          />
        </section>
      </div>
    </div>
  </transition>
</template>

<script>
import FormWeek from "./FormWeek.vue";

export default {
  name: "Modal",
  components: {
    FormWeek,
  },
  props: {
    coursIft: String,
    week: Object,
  },
  methods: {
    toggleModal() {
      this.$emit("toggleModal");
    },
    addWeek(data) {
      this.$emit("addWeek", data);
    },
    updateWeek(editWeek) {
      this.$emit("updateWeek", editWeek);
    },
  },
};
</script>

<style>
.modal-back {
  display: flex;
  position: fixed;
  height: 100vh;
  width: 100vw;
  top: 0;
  left: 0;
  z-index: 1040;
  align-items: center;
  justify-content: center;
  background-color: rgba(0, 0, 0, 0.5);
}

.modal-front {
  display: flex;
  position: fixed;
  max-height: 90vh;
  width: 60%;
  margin: 0 auto;
  overflow-x: hidden;
  overflow-y: auto;
  outline: 0;
  z-index: 1050;
  border-radius: 10px;
  flex-direction: column;
  background-color: white;
}
.modal-header {
  display: block;
  position: relative;
  padding: 15px;
  border: none;
  justify-content: space-between;
}
.modal-title {
  text-align: center;
  color: #1f2833;
}
.modal-body {
  position: relative;
  padding: 0 15px;
  margin-top: 10px;
  text-align: left;
}
.modal-footer {
  padding: 15px;
  border-top: 1px solid #eeeeee;
  flex-direction: column;
}
.closeModalButton {
  position: absolute;
  top: 10px;
  right: 12px;
  border: none;
  font-size: 32px;
  color: #1d00db;
}
</style>
