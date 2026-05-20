<script setup lang="ts">
import { ref } from "vue";
const drawer = ref(false);
</script>
<template>
  <v-app-bar elevation="0" border class="toolbar">
    <v-app-bar-nav-icon
      variant="text"
      @click.stop="drawer = !drawer"
    ></v-app-bar-nav-icon>

    <v-app-bar-title>Nickels</v-app-bar-title>
  </v-app-bar>

  <v-navigation-drawer
    v-model="drawer"
    :location="$vuetify.display.mobile ? 'bottom' : undefined"
    temporary
  >
    <v-list nav>
      <v-list-item link to="/">Home</v-list-item>
      <v-list-item link to="/login">Login</v-list-item>
      <v-list-item link to="/signin">Sign In</v-list-item>
    </v-list>
  </v-navigation-drawer>
</template>
