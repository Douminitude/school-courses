<template>
	<router-link class="nav-tab-link" :to="tab.path">{{tab.shortname}}</router-link>
</template>

<script>
export default {
	name: 'Tab',
	props: {
		tab: Object
	}
}
</script>

<style>
	.nav-tab-link {
		display: block;
		padding-top: .25rem;
		text-decoration: none;
		border-bottom: 4px solid transparent;
		transition: color .15s ease-in, 
					border-color .15s ease-in-out;
	}
	.router-link-active {
		border-bottom: 4px solid white;
	}
</style>
