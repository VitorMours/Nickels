<script setup lang="ts">
  import HeaderNavBar from './ui/components/HeaderNavBar.vue';
</script>

<template>
  <v-app>
    <HeaderNavBar />
    <v-main fluid fill-height>
    <router-view />
    </v-main>
  </v-app>
</template>

<style>

</style>