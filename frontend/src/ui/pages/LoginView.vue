<script setup lang="ts">
import { ref } from "vue";
import HeaderNavBar from "../components/HeaderNavBar.vue";

const email = ref("");
const password = ref("");

function submit() {
  console.log(email.value, password.value);
}
</script>

<template>
  <v-container
    fluid
    class="d-flex justify-center align-center fill-height"
  >
    <v-sheet
      width="450"
      elevation="3"
      class="pa-8 d-flex flex-column ga-4"
      rounded
    >
      <h3>Log in</h3>

      <p>Insira suas Credenciais</p>

      <v-form @submit.prevent="submit" class="d-flex flex-column ga-3">
        <v-text-field v-model="email" label="Email" />
        <v-text-field v-model="password" label="Password" />

        <v-btn type="submit" color="primary">
          Entrar
        </v-btn>
      </v-form>
    </v-sheet>
  </v-container>
</template>