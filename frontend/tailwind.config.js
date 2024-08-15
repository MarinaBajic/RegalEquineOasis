/** @type {import('tailwindcss').Config} */
module.exports = {
  content: ["./src/**/*.{html,ts}"],
  theme: {
    extend: {
      colors: {
        light: "#f2f2f2",
        dark: "hsl(135, 38%, 18%)",
        accent: "hsl(27, 48%, 49%)",
        "accent-light": "hsl(27, 48%, 59%)",
      },
    },
  },
  plugins: [],
};
