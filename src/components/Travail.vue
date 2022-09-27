<template>
    <a class="travail-link" :href='travail.ou' target="_blank">
        <h5 class="travail-text travail-quoi">{{ travail.quoi }}</h5>
        <h6 class="travail-text travail-quand">{{ travail.quand }}</h6>
        <p  class="travail-text travail-combien body1">{{ travail.combien }}</p>
    </a>
</template>

<script>
export default {
    name: 'Travail',
    props: {
        travail: Object,
    }
}
</script>

<style>
    .travail-link {
        height: 100%;
        width: 100%;
        color: black;
    }
    .travail-link:hover {
        color: black;
    }
    .travail-text {
        display: block;
        font-family: 'Montserrat';
    }
    .travail-quoi {
        margin: 15px 0;
    }
    .travail-quand {
        margin: 10px 0;
    }
    .travail-combien {
        margin: 15px 0 15px 0;
    }
</style>