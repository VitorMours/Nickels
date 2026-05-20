<script setup lang="ts">
  import HeaderNavBar from './ui/components/HeaderNavBar.vue';
</script>

<template>
  <v-app>
    <HeaderNavBar />
    <v-main><router-view /></v-main>
  </v-app>
</template>

<style>

</style>