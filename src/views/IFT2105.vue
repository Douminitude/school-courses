<template>
  <div class="ift2105">
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
  name: "IFT2105",
  components: {
    Header,
    Session,
  },
  data() {
    return {
      travaux: [],
      ressources: [],
      coursSpecs: {
        cours: "IFT2105",
        coursNom: "Introduction à l'informatique théorique",
      },
    };
  },
  created() {
    (this.travaux = [
      {
        id: 1,
        quoi: "Devoir 1",
        quand: "1 juin 2021 23h59",
        combien: "6%",
        ou: "./IFT2105/devoir1.pdf",
        class: "Row1-Tiers1 hov",
      },
      {
        id: 2,
        quoi: "Devoir 2",
        quand: "21 juin 2021 12h",
        combien: "6%",
        ou: "./IFT2105/devoir2.pdf",
        class: "Row1-Tiers2 hov",
      },
      {
        id: 3,
        quoi: "Devoir 3",
        quand: "14 juillet 2021 12h",
        combien: "6%",
        ou: "./IFT2105/devoir3.pdf",
        class: "Row1-Tiers3 hov",
      },
      {
        id: 4,
        quoi: "Devoir 4",
        quand: "23 juillet 2021 10h",
        combien: "6%",
        ou: "./IFT2105/devoir4.pdf",
        class: "Row2-Demie1 hov",
      },
      {
        id: 5,
        quoi: "Devoir 5",
        quand: "Never",
        combien: "6%",
        // ou: './IFT2105/travail',
        class: "Row2-Demie2",
      },
      {
        id: 6,
        quoi: "Intra",
        quand: "23 juin 2021",
        combien: "30%",
        // ou: './IFT2105/travail',
        class: "Row3-Demie1",
      },
      {
        id: 7,
        quoi: "Final",
        quand: "26 juillet 2021",
        combien: "40%",
        // ou: './IFT2105/travail',
        class: "Row3-Demie2",
      },
    ]),
      (this.ressources = [
        {
          id: 1,
          quoi: "Plan de cours",
          ou: "./IFT2105/PlanDeCours_IFT2105.pdf",
          lineHeight: 5,
        },
        {
          id: 2,
          quoi: "Introduction to the Theory of Computation",
          ou: "./IFT2105/Introduction_to_the_Theory_of_Computation.pdf",
          lineHeight: 5,
        },
      ]);
  },
};
</script>

<style></style>
