/** @type {import('tailwindcss').Config} */
module.exports = {
  content: ["./src/**/*.{html,ts}"],
  theme: {
    extend: {
      colors: {
        accent: "#eab308",
        "accent-light": "#facc15",
        dark: "#333",
        light: "#f2f2f2",
      },
    },
  },
  plugins: [],
};
