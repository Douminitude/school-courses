<template>
  <router-link :to="classe.path" tag="div">
    <div class="card card-bg card-h">
      <div class="card-body align-middle">
        <h5 class="card-title">{{ classe.shortname }}</h5>
        <h6 class="card-subtitle mb-2">{{ classe.fullname }}</h6>
      </div>
    </div>
  </router-link>
</template>

<script>
export default {
  name: "Classe",
  props: {
    classe: Object,
  },
};
</script>

<style>
.card-bg {
  background-color: white;
  box-shadow: 0 3px 8px #bbbbbb;
  border-radius: 8px;
}
.card-h {
  height: 100%;
}
.card-body {
  flex: 0 1 auto;
  margin: auto 0;
}
.card-title {
  color: black;
  font-size: 32px;
  text-decoration: none;
}
.card-subtitle {
  color: #a1a1a1;
  font-size: 24px;
}
router-link {
  text-decoration: none;
  text-decoration-line: none;
}
</style>
