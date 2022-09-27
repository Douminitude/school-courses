<template>
    <div class="travaux">
        <h4>Évaluations</h4>
        <div class="grid-container">
            <div class="grid-child" :class="travail.class" :key="travail.id" v-for="travail in travaux">
                <Travail :travail="travail"/>
            </div>
        </div>
    </div>
</template>

<script>
import Travail from './Travail.vue'

export default {
    name: 'Travaux',
    components: {
        Travail,
    },
    props: {
        coursInfo:  String,
        travaux:    Array
    }
}
</script>

<style>
    .travaux {
        display: block;
        position: relative;
        width: 100%;
        padding: 0 50px;
        text-align: center;
        background-color: white;
    }
    .grid-container {
        display: grid;
        padding-top: 30px;
        grid-template-rows: auto;
        justify-content: space-evenly;
        grid-template-columns: 11.11% 11.11% 11.11% 11.11% 11.11% 11.11% 11.11% 11.11% 11.11%;
    }
    .grid-child {
        display: flex;
        width: 90%;
        min-height: 150px;
        margin: 20px auto;
        border-radius: 10px;
        flex-direction: column;
        background-color: white;
        justify-content: space-between;
        /* transition: background-color 15ms linear; */
        box-shadow: 0px  3px 3px -1px rgba(0, 0, 0, 0.20),
                    0px  1px 1px  0px rgba(0, 0, 0, 0.14),
                    0px  1px 3px  0px rgba(0, 0, 0, 0.12), 
                    0px -1px 1px  0px rgba(0, 0, 0, 0.12);
    }
    /* .grid-child:hover {
        background-color: #f5f5f5;
        box-shadow: 0 1px 3px 1px rgba(66, 66, 66, 0.2), 
                    0 2px 8px 4px rgba(66, 66, 66, 0.1);
    } */
    .hov {
        background-color: white;
        transition: background-color 15ms linear;
        box-shadow: 0px  3px 3px -1px rgba(0, 0, 0, 0.20),
                    0px  1px 1px  0px rgba(0, 0, 0, 0.14),
                    0px  1px 3px  0px rgba(0, 0, 0, 0.12), 
                    0px -1px 1px  0px rgba(0, 0, 0, 0.12);
    }
    .hov:hover {
        background-color: #f5f5f5;
        box-shadow: 0 1px 1px 1px rgba(66, 66, 66, 0.2), 
                    0 2px 5px 2px rgba(66, 66, 66, 0.1);
    }
    .hov:hover .travail-quoi {
        color: #0000a8;
    }
    .Row1-Tiers1 {
        grid-column-start: 1;
        grid-column-end: 4;
        grid-row-start: 1;
        grid-row-end: 2;
    }
    .Row1-Tiers2 {
        grid-column-start: 4;
        grid-column-end: 7;
        grid-row-start: 1;
        grid-row-end: 2;
    }
    .Row1-Tiers3 {
        grid-column-start: 7;
        grid-column-end: 10;
        grid-row-start: 1;
        grid-row-end: 2;
    }
    .Row2-Tiers2 {
        grid-column-start: 4;
        grid-column-end: 7;
        grid-row-start: 2;
        grid-row-end: 3;
    }
    .Row2-Demie1 {
        grid-column-start: 2;
        grid-column-end: 5;
        grid-row-start: 2;
        grid-row-end: 3;
    }
    .Row2-Demie2 {
        grid-column-start: 6;
        grid-column-end: 9;
        grid-row-start: 2;
        grid-row-end: 3;
    }
    .Row3-Tiers1 {
        grid-column-start: 1;
        grid-column-end: 4;
        grid-row-start: 3;
        grid-row-end: 4;
    }
    .Row3-Tiers2 {
        grid-column-start: 4;
        grid-column-end: 7;
        grid-row-start: 3;
        grid-row-end: 4;
    }
    .Row3-Tiers3 {
        grid-column-start: 7;
        grid-column-end: 10;
        grid-row-start: 3;
        grid-row-end: 4;
    }
    .Row3-Demie1 {
        grid-column-start: 2;
        grid-column-end: 5;
        grid-row-start: 3;
        grid-row-end: 4;
    }
    .Row3-Demie2 {
        grid-column-start: 6;
        grid-column-end: 9;
        grid-row-start: 3;
        grid-row-end: 4;
    }
    .Row4-Demie1 {
        grid-column-start: 2;
        grid-column-end: 5;
        grid-row-start: 4;
        grid-row-end: 5;
    }
    .Row4-Demie2 {
        grid-column-start: 6;
        grid-column-end: 9;
        grid-row-start: 4;
        grid-row-end: 5;
    }
</style>