<template>
  <v-container class="user">
    <div v-if="selectedUser === 0">
      Пользователь не найден
    </div>
    <v-layout
      v-else
      row
    >
      <v-flex class="user__info">
        <!--{{ selectedUser[0] }}-->
        <v-layout column align-start>
          <v-flex class="display-3">
            <v-avatar
              size="150px"
              color="green lighten-4"
            >
              {{selectedUser[0].username | firstLetter}}
            </v-avatar>
            Рейтинг: {{selectedUser[0].ratio}}
          </v-flex>
          <v-flex class="display-1">
            {{selectedUser[0].username}}
          </v-flex>
          <v-flex class="display-1">
            {{selectedUser[0].first_name}} {{selectedUser[0].last_name}}
          </v-flex>
        </v-layout>
      </v-flex>
      <v-flex class="user__achievement">
        <v-layout column>
          <v-flex>
            ачивка
          </v-flex>
          <v-flex>
            ачивка
          </v-flex>
        </v-layout>
      </v-flex>
    </v-layout>
  </v-container>
</template>

<script>
export default {
  name: 'User',
  data() {
    return {
      users: [
        {
          user_id: 1,
          username: 'Иван',
          first_name: 'Иван',
          last_name: 'Иванов',
          data_reg: '16 января',
          ratio: 1,
          achievements: [
            {
              id: 'id1',
              name: 'ачивка номер 1',
              cost: 15,
            },
            {
              id: 'id2',
              name: 'ачивка номер 2',
              cost: 15,
            },
            {
              id: 'id3',
              name: 'ачивка номер 2',
              cost: 15,
            },
          ],
        },
        {
          user_id: 2,
          username: 'Дмитрий',
          first_name: 'Дмитрий',
          last_name: 'Дмитриев',
          data_reg: '6 мая',
          ratio: 1,
          achievements: [
            {
              id: 'id1',
              name: 'ачивка номер 1',
              cost: 15,
            },
            {
              id: 'id2',
              name: 'ачивка номер 2',
              cost: 15,
            },
            {
              id: 'id3',
              name: 'ачивка номер 2',
              cost: 15,
            },
          ],
        },
      ],
    };
  },
  filters: {
    firstLetter(text) {
      return text.substr(0, 1).toUpperCase()
    },
  },
  computed: {
    id() {
      console.log();
    },
    selectedUser() {
      const { users } = this;
      const userId = Number(this.$route.params.id);
      return users.filter(item => item.user_id === userId);
    },
  },
};
</script>

<style lang="scss" scoped>
.user {
  &__info,
  &__achievement {
    width: 50%;
  }
}
</style>
