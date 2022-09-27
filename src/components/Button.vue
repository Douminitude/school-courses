<template>
  <button @click="onClick()" class="btn">
    <i class="bi bi-plus"></i>
  </button>
</template>

<script>
export default {
  name: "Button",
  props: {
    text: String,
  },
  methods: {
    onClick() {
      this.$emit("toggle-add-week");
    },
  },
};
</script>

<style>
.btn {
  position: fixed;
  bottom: 3vw;
  right: 3vw;
  width: 50px;
  height: 50px;
  background-color: #1d00db;
  border-radius: 100px;
  padding: 0;
  z-index: 5;
  color: white;
}
.btn:focus {
  box-shadow: none;
}
/* .btn:hover {
		color: #00cfd3;
	} */
i.bi.bi-plus {
  display: inline-block;
  height: 100%;
  width: 100%;
  font-size: 30px;
  vertical-align: middle;
}
</style>
