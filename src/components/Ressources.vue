<template>
    <div class="ressources">
        <h4>Ressources</h4>
        <div class="ressource" :key="ressource.id" v-for="ressource in ressources">
            <a class="ressource-doc" :href="ressource.ou" :style="{'line-height': ressource.lineHeight + 'vw'}" target="_blank">{{ ressource.quoi }}</a>
        </div>
    </div>
</template>

<script>

export default {
    name: 'Ressources',
    props: {
        coursInfo:  String,
        ressources: Array,
    }
}
</script>

<style>
    .ressources {
        display: block;
        position: relative;
        width: 100%;
        text-align: center;
        padding: 0 50px 50px 50px;
        background-color: white;
    }
    .ressource {
        display: block;
        width: 100%;
        height: 7vw;
        margin: 0px auto;
        padding: 1vw 0;
        border-bottom: 1px solid #2c3e50;  
    }
    .ressource:nth-child(odd) {
        background-color: #f0f0f0;
    }
    .ressource-doc {
        position: relative;
        font-size: 1.5em;
        color: #3500d3;
        white-space: pre-wrap;
    }
</style>