/** @type {import('tailwindcss').Config} */
export default {
    content: [
      "./index.html",
      "./src/**/*.{js,ts,jsx,tsx}", // 👈 ISSO AQUI É CRUCIAL! Ele avisa ao Tailwind para olhar a pasta src
    ],
    theme: {
      extend: {},
    },
    plugins: [
      require("daisyui") // 👈 Verifique se o daisyUI está injetado nos plugins
    ],
  }