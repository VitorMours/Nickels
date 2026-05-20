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
        class="flex flex-col justify-center align-center content-center items-center h-full"
      >
        <h3 fluid class="flex justify-center w-100 text-xl mb-12">Log in</h3>
        <v-sheet
          width="450"
          elevation="3"
          class="p-8"
          rounded
        >


          <v-form @submit.prevent="submit" class="d-flex flex-column g-3">
            <v-text-field 
              v-model="email" 
              label="Email" 
              type="email"
              required 
            />

            <v-text-field 
              v-model="password" 
              label="Password" 
              type="password"
              required 
            />

            <v-btn type="submit" color="primary" block>
              Entrar
            </v-btn>
          </v-form>
        </v-sheet>
      </v-container>
</template>