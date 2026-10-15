import { createApp } from 'vue'
import App from './App.vue'
import PrimeVue from 'primevue/config';
import { router } from './router/index.ts'; 
import ToastService from 'primevue/toastservice'
import Aura from '@primeuix/themes/aura'
import 'primeicons/primeicons.css'

const app = createApp(App);
app.use(PrimeVue,
  {
    theme: { preset: Aura },
  }
);
app.use(router)
.use(ToastService)
app.mount('#app');
