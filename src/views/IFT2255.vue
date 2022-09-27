<template>
  <div class="ift2255">
    <Header :cours="this.coursSpecs.cours" />
    <Session
      :coursSpecs="this.coursSpecs"
      :travaux="travaux"
      :ressources="ressources"
    />
  </div>
</template>

<script>
import Header from "../components/Header.vue";
import Session from "../components/Session.vue";

export default {
  name: "IFT2255",
  components: {
    Header,
    Session,
  },
  data() {
    return {
      travaux: [],
      ressources: [],
      coursSpecs: {
        cours: "IFT2255",
        coursNom: "Génie logiciel",
      },
    };
  },
  created() {
    (this.travaux = [
      {
        id: 1,
        quoi: "Test 1",
        quand: "21 mai 2021",
        combien: "10%",
        // ou: './IFT2255/travail',
        class: "Row1-Tiers1",
      },
      {
        id: 2,
        quoi: "Test 2",
        quand: "11 juin 2021",
        combien: "10%",
        // ou: './IFT2255/travail',
        class: "Row1-Tiers2",
      },
      {
        id: 3,
        quoi: "Test 3",
        quand: "29 juin 2021",
        combien: "10%",
        // ou: './IFT2255/travail',
        class: "Row1-Tiers3",
      },
      {
        id: 4,
        quoi: "Test 4",
        quand: "16 juillet 2021",
        combien: "10%",
        // ou: './IFT2255/travail',
        class: "Row2-Tiers2",
      },
      {
        id: 5,
        quoi: "Devoir 1",
        quand: "10 juin 2021 23h55",
        combien: "20%",
        ou: "http://benomaro.com/ift2255/devoir1.html",
        class: "Row3-Tiers1 hov",
      },
      {
        id: 6,
        quoi: "Devoir 2",
        quand: "25 juin 2021 23h55",
        combien: "20%",
        ou: "http://benomaro.com/ift2255/devoir2.html",
        class: "Row3-Tiers2 hov",
      },
      {
        id: 7,
        quoi: "Devoir 3",
        quand: "18 juillet 2021 23h55",
        combien: "20%",
        ou: "http://benomaro.com/ift2255/devoir3.html",
        class: "Row3-Tiers3 hov",
      },
    ]),
      (this.ressources = [
        {
          id: 1,
          quoi: "Plan de cours",
          ou: "./IFT2255/PlanDeCours_IFT2255.pdf",
          lineHeight: 5,
        },
        {
          id: 2,
          quoi: "Object-Oriented and Classical Software Engineering",
          ou: "./IFT2255/Object-Oriented_and_Classical_Software_Engineering.pdf",
          lineHeight: 5,
        },
        {
          id: 3,
          quoi: "Software Engineering - The Current Practice",
          ou: "./IFT2255/Software_Engineering-The_Current_Practice.pdf",
          lineHeight: 5,
        },
        // {
        // 	id: 4,
        // 	quoi: 'DunnoYet',
        // 	ou: './IFT2255/',
        // },
        // {
        // 	id: 5,
        // 	quoi: 'DunnoYet',
        // 	ou: './IFT2255/',
        // }
      ]);
  },
};
</script>

<style></style>
