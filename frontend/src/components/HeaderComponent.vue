<template>
  <header class="header">
    <nav class="navbar">
      <div class="logo">
        <h2>{{ appName }}</h2>
      </div>
      
      <ul class="nav-links">
        <li v-for="item in menuItems" :key="item.name">
          <a 
            :href="item.path" 
            :class="{ active: currentRoute === item.path }"
            @click.prevent="navigateTo(item.path)"
          >
            {{ item.name }}
          </a>
        </li>
      </ul>
      
      <div class="user-info" v-if="user">
        <span>Olá, {{ user.name }}</span>
        <button @click="handleLogout" class="logout-btn">Sair</button>
      </div>
    </nav>
  </header>
</template>

<script>
export default {
  name: 'AppHeader',
  props: {
    user: {
      type: Object,
      default: null
    }
  },
  data() {
    return {
      appName: 'Meu App Vue',
      currentRoute: '/',
      menuItems: [
        { name: 'Home', path: '/' },
        { name: 'Sobre', path: '/sobre' },
        { name: 'Produtos', path: '/produtos' },
        { name: 'Contato', path: '/contato' }
      ]
    }
  },
  methods: {
    navigateTo(path) {
      this.currentRoute = path
      // Em um projeto real, você usaria Vue Router
      // this.$router.push(path)
      this.$emit('navigate', path)
    },
    handleLogout() {
      this.$emit('logout')
    }
  }
}
</script>

<style scoped>

</style>