<template>
  <div id="app">
    <AppHeader 
      :user="currentUser" 
      @navigate="handleNavigation"
      @logout="handleLogout"
    />
    
    <main class="main-content">
      <div class="container">
        <h1>{{ currentPageTitle }}</h1>
        <p>Conteúdo da página {{ currentRoute }}</p>
        
        <div v-if="currentUser" class="welcome-message">
          <h3>Bem-vindo de volta, {{ currentUser.name }}!</h3>
        </div>
        
        <button v-else @click="handleLogin" class="login-btn">
          Fazer Login
        </button>
      </div>
    </main>
  </div>
</template>

<script>
import AppHeader from './components/Header.vue'

export default {
  name: 'App',
  components: {
    AppHeader
  },
  data() {
    return {
      currentRoute: '/',
      currentUser: null
    }
  },
  computed: {
    currentPageTitle() {
      const titles = {
        '/': 'Página Inicial',
        '/sobre': 'Sobre Nós',
        '/produtos': 'Nossos Produtos',
        '/contato': 'Entre em Contato'
      }
      return titles[this.currentRoute] || 'Página Não Encontrada'
    }
  },
  methods: {
    handleNavigation(path) {
      this.currentRoute = path
    },
    handleLogin() {
      this.currentUser = {
        name: 'João Silva',
        email: 'joao@exemplo.com'
      }
    },
    handleLogout() {
      this.currentUser = null
      this.currentRoute = '/'
    }
  }
}
</script>

<style>
* {
  margin: 0;
  padding: 0;
  box-sizing: border-box;
}

body {
  font-family: 'Arial', sans-serif;
  background-color: #f5f5f5;
}

#app {
  min-height: 100vh;
}

.main-content {
  padding: 2rem;
}

.container {
  max-width: 1200px;
  margin: 0 auto;
  background: white;
  padding: 2rem;
  border-radius: 8px;
  box-shadow: 0 2px 10px rgba(0,0,0,0.1);
}

.welcome-message {
  background-color: #e8f5e8;
  padding: 1rem;
  border-radius: 4px;
  margin: 1rem 0;
}

.login-btn {
  background-color: #42b883;
  color: white;
  border: none;
  padding: 0.75rem 1.5rem;
  border-radius: 4px;
  cursor: pointer;
  font-size: 1rem;
  transition: background-color 0.3s;
}

.login-btn:hover {
  background-color: #369870;
}
</style>