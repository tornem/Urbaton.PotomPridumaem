<template xmlns:v-slot="http://www.w3.org/1999/XSL/Transform">
  <v-container class="rating">
    <v-layout
      column
    >
      <v-flex xs6>
        <v-text-field
          solo
          label="Regular"
        ></v-text-field>
      </v-flex>

      <v-flex xs6>
        <v-expansion-panel>
          <v-expansion-panel-content
            v-for="item in users"
            :key="i"
          >

            <template v-slot:header>
              <div>{{item.title}}</div>
            </template>

            <v-card>
              <v-card-text>
                {{item.text}}
              </v-card-text>
            </v-card>
          </v-expansion-panel-content>
        </v-expansion-panel>
      </v-flex>
    </v-layout>
  </v-container>
</template>

<script>
export default {
  data() {
    return {
      users: [
        {
          title: '1',
          text: '1',
        },
        {
          title: '2',
          text: '2',
        },
        {
          title: '3',
          text: '3',
        },
      ],
    };
  },
};
</script>

<style lang="scss" scoped>
.rating {
  max-width: 800px;
}
</style>
