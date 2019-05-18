<template xmlns:v-slot="http://www.w3.org/1999/XSL/Transform">
  <v-container class="rating">
    <v-layout
      column
    >
      <v-flex xs6>
        <v-text-field
          solo
          label="Введите ник пользователя"
          v-model="searchQuery"
        ></v-text-field>
      </v-flex>

      <v-flex xs6>
        <v-list
          two-line
          class="users"
        >
          <router-link
            class="users__item"
            v-for="(item, i) in filteredRatings"
            :key="item.user_id"
            :to="`/user/${item.user_id}`"
          >
            <v-list-tile
              avatar
              size="100px"
            >
              <v-list-tile-avatar>
                <img
                  :src="`https://picsum.photos/500/300?image=${i * 5 + 10}`"
                >
              </v-list-tile-avatar>

              <v-list-tile-content>
                <v-list-tile-title>
                  {{item.username}}
                </v-list-tile-title>
                <v-list-tile-sub-title>
                  {{i+1}} место
                </v-list-tile-sub-title>
              </v-list-tile-content>

              <div
                class="users__rating"
              >
                <v-rating
                  value="5"
                  color="amber"
                  dense
                  half-increments
                  readonly
                  size="14"
                ></v-rating>
                <div class="ml-2 grey--text text--darken-2">
                  <span>{{item.ratio}}</span>
                </div>
              </div>
            </v-list-tile>

            <v-divider></v-divider>
          </router-link>
        </v-list>
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
          user_id: '1',
          username: 'Иван',
          ratio: '1',
        },
        {
          user_id: '2',
          username: 'Дмитрий',
          ratio: '2',
        },
        {
          user_id: '3',
          username: 'Олег',
          ratio: '3',
        },
        {
          user_id: '4',
          username: 'Колобок',
          ratio: '4',
        },
      ],
      searchQuery: '',
    };
  },
  computed: {
    filteredRatings() {
      let { users, searchQuery } = this;
      searchQuery = searchQuery.toLowerCase();

      if (searchQuery) {
        users = users.filter(item => item.username.toLowerCase().indexOf(searchQuery) > -1);
      }

      return users;
    },
  },
};
</script>

<style lang="scss" scoped>
.rating {
  max-width: 800px;
}
  .users {
    &__item {
      text-decoration: none;

      &:hover > div {
        background-color: ghostwhite;
      }
    }
    &__rating {
      display: flex;
    }
  }
</style>
