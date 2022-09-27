<template>
	<div class="ift2015">
		<Header :cours="this.coursSpecs.cours"/>
		<Session :coursSpecs="this.coursSpecs" :travaux="this.travaux" :ressources="this.ressources" />
	</div>
</template>

<script>
import Header from '../components/Header.vue'
import Session from '../components/Session.vue'

export default {
	name: 'IFT2015',
	components: {
		Header,
		Session,
	},
	data() {
		return {
			travaux: [], 
			ressources: [],
			coursSpecs: {
				cours: "IFT2015",
				coursNom: "Structures de données"
			}
		}
	},
	created() {
		this.travaux = [
			{
				id: 1,
				quoi: 'Devoir 1',
				quand: '2 juin 2021 9h',
				combien: '10%',
				ou: './IFT2015/devoir1.pdf',
				class: 'Row1-Tiers1 hov'
			},
			{
				id: 2,
				quoi: 'Devoir 2',
				quand: '16 juin 2021 8h',
				combien: '10%',
				ou: './IFT2015/devoir2.pdf',
				class: 'Row1-Tiers2 hov'
			},
			{
				id: 3,
				quoi: 'Devoir 3',
				quand: '14 juillet 2021 9h',
				combien: '10%',
				ou: './IFT2015/devoir3.pdf',
				class: 'Row1-Tiers3 hov'
			},
			{
				id: 4,
				quoi: 'Intra',
				quand: '8 juin 2021 9h - 9 juin 2021 11h',
				combien: '30%',
				// ou: './IFT2015/travail',
				class: 'Row2-Demie1'
			},
			{
				id: 5,
				quoi: 'Final',
				quand: '21 juillet 2021',
				combien: '40%',
				// ou: './IFT2015/travail',
				class: 'Row2-Demie2'
			}
		],
		this.ressources = [
			{
				id: 1,
				quoi: 'Plan de cours',
				ou: './IFT2015/PlanDeCours_IFT2015.pdf',
				lineHeight: 5
			},
			{
				id: 2,
				quoi: 'Data Structures and Algorithm Analysis in Java',
				ou: './IFT2015/Data_Structures_and_Algorithm_Analysis_in_Java.pdf',
				lineHeight: 5
			},
			{
				id: 3,
				quoi: 'The Art of Computer Programming - Volume 1\nFundamental Algorithms',
				ou: './IFT2015/The_Art_of_Computer_Programming-Vol1.pdf',
				lineHeight: 2.5
			},
			{
				id: 4,
				quoi: 'The Art of Computer Programming - Volume 2\nSeminumerical Algorithms',
				ou: './IFT2015/The_Art_of_Computer_Programming-Vol2.pdf',
				lineHeight: 2.5
			},
			{
				id: 5,
				quoi: 'The Art of Computer Programming - Volume 3\nSorting and Searching',
				ou: './IFT2015/The_Art_of_Computer_Programming-Vol3.pdf',
				lineHeight: 2.5
			}
		]
	}
}
</script>

<style>

</style>