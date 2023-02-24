<template>
  <div lang="en" class="home">
    <input type="text" v-model="content" />
    <div class="content" v-html="t()"></div>
    <div class="content">this d is pain&#8209;in amount</div>
  </div>
</template>

<script lang="ts">
import Vue from "vue";

export default Vue.extend({
  name: "Home",
  data() {
    return {
      // content: "this is a e-mail",
      content: "eacailceacailceacailceacailc",
    };
  },
  methods: {
    t() {
      // return "this d is pain-in amount";
      return "this d is pain&#8209;in amount"
    },
  },
});
</script>


<style lang="scss" scoped>
.content {
  color: red;
  border: 1px solid red;
  width: 100px;
  height: 200px;
  text-align: left;
  hyphens: auto;
}
</style>