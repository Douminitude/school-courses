<template>
	<div class="home">
		<h2>Session Été 2021</h2>
		<Classes :classes="classes" msg="Session Été 2021" />
	</div>
</template>

<script>
// @ is an alias to /src
import Classes from "@/components/Classes.vue";

export default {
    name: "Home",
    components: {
      Classes,
    },
    data() {
      return {
        classes: []
      }
    },
    created() {
      this.classes = [
        {
          id: 1,
          fullname: "Structures de données",
          shortname: "IFT2015",
          path: "/IFT2015"
        },
        {
          id: 2,
          fullname: "Concepts de langages de programmation",
          shortname: "IFT2035",
          path: "/IFT2035"
        },
        {
          id: 3,
          fullname: "Introduction à l'informatique théorique",
          shortname: "IFT2105",
          path: "/IFT2105"
        },
        {
          id: 4,
          fullname: "Génie logiciel",
          shortname: "IFT2255",
          path: "/IFT2255"
        }
      ]
    }
};
</script>

<style>
	.home {
		margin-top: 40px;
	}
</style>
