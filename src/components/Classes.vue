<template>
  <div class="classes">
    <div class="row row-cols-1 row-cols-md-2 g-5">
      <div class="col col-h" :key="classe.id" v-for="classe in classes">
        <Classe :classe="classe" />
      </div>
    </div>
  </div>
</template>

<script>
import Classe from "./Classe";

export default {
  name: "Classes",
  props: {
    classes: Array,
  },
  components: {
    Classe,
  },
};
</script>

<style>
.classes {
  margin: 30px 40px 40px 40px;
}
.col-h {
  min-height: 30vh;
  text-decoration: none;
}
</style>
