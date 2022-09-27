<template>
    <div class="task" :key="task.taskName" v-for="task in tasks">
        <Task :task="task" @checkMe="checkMe"/>
    </div>
</template>

<script>
import Task from './Task.vue'

export default {
    name: 'Tasks',
    components: {
        Task,
    },
    props: {
        tasks: Array,
    },
    methods: {
        checkMe(task) {
            this.$emit('checkMe', task);
        }
    },
}
</script>

<style>
    .task {
        display: block;
        min-height: 1.5rem;
        margin-bottom: .125rem;
    }
</style>