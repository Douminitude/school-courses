<template>
  <div class="ift2035">
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
  name: "IFT2035",
  components: {
    Header,
    Session,
  },
  data() {
    return {
      travaux: [],
      ressources: [],
      coursSpecs: {
        cours: "IFT2035",
        coursNom: "Concepts de langages de programmation",
      },
    };
  },
  created() {
    (this.travaux = [
      {
        id: 1,
        quoi: "Exercices 2½",
        quand: "12 mai 2021 23h",
        combien: "2%",
        ou: "./IFT2035/ex2.5.pdf",
        class: "Row1-Tiers1 hov",
      },
      {
        id: 2,
        quoi: "Exercices 4½",
        quand: "20 mai 2021 23h",
        combien: "2%",
        ou: "./IFT2035/ex4.5.pdf",
        class: "Row1-Tiers2 hov",
      },
      {
        id: 3,
        quoi: "Exercices 7½",
        quand: "3 juin 2021 23h",
        combien: "2%",
        ou: "./IFT2035/ex7.5.pdf",
        class: "Row1-Tiers3 hov",
      },
      {
        id: 4,
        quoi: "Exercices 9½",
        quand: "9 juin 2021 23h",
        combien: "2%",
        ou: "./IFT2035/ex9.5.pdf",
        class: "Row2-Demie1 hov",
      },
      {
        id: 5,
        quoi: "Exercices 10½",
        quand: "15 juin 2021 23h",
        combien: "2%",
        ou: "./IFT2035/ex10.5.pdf",
        class: "Row2-Demie2 hov",
      },
      {
        id: 6,
        quoi: "TP 1",
        quand: "1 juin 2021 23h59",
        combien: "20%",
        ou: "./IFT2035/TP1-Enonce.pdf",
        class: "Row3-Demie1 hov",
      },
      {
        id: 7,
        quoi: "TP 2",
        quand: "24 juin 2021 23h59",
        combien: "20%",
        ou: "./IFT2035/TP2-Enonce.pdf",
        class: "Row3-Demie2 hov",
      },
      {
        id: 8,
        quoi: "Intra",
        quand: "26 mai 2021",
        combien: "25%",
        ou: "./IFT2035/IntraE21.pdf",
        class: "Row4-Demie1 hov",
      },
      {
        id: 9,
        quoi: "Final",
        quand: "17 juin 2021",
        combien: "25%",
        // ou: './IFT2035/travail',
        class: "Row4-Demie2",
      },
    ]),
      (this.ressources = [
        {
          id: 1,
          quoi: "Plan de cours",
          ou: "http://www.iro.umontreal.ca/~monnier/2035/",
          lineHeight: 5,
        },
        {
          id: 2,
          quoi: "Programming Language Design Concepts",
          ou: "./IFT2035/Programming_Language_Design_Concepts.pdf",
          lineHeight: 5,
        },
        {
          id: 3,
          quoi: "Programming Languages Concepts and Constructs",
          ou: "./IFT2035/Programming_Languages_Concepts_and _Constructs.pdf",
          lineHeight: 5,
        },
        {
          id: 4,
          quoi: "Programming in Haskell",
          ou: "./IFT2035/Programming_in_Haskell.pdf",
          lineHeight: 5,
        },
        // {
        // 	id: 5,
        // 	quoi: 'DunnoYet',
        // 	ou: './IFT2035/',
        // }
      ]);
  },
};
</script>

<style></style>
