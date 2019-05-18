<template>
  <v-container class="achievement">
    <v-layout
      column
    >
      <v-flex xs6>
        <v-text-field
          solo
          label="Введите название ачивки"
          v-model="searchQuery"
        ></v-text-field>
      </v-flex>

      <v-layout row wrap justify-flex-start
        class="achievement__container"
      >
        <v-flex
          xs6
          v-for="(item, i) in filteredAchievements"
          :key="item.id"
          class="achievement__item"
        >
          <v-card>
            <!--<v-img-->
              <!--:src="item.icon"-->
              <!--class="achievement__img"-->
              <!--aspect-ratio="2.75"-->
            <!--&gt;</v-img>-->
            <v-img
              :src="`https://picsum.photos/500/300?image=${i * 11 + 10}`"
              class="achievement__img"
              aspect-ratio="2.75"
            ></v-img>

            <v-card-title
              class="achievement__title"
            >
              <h4 class="headline mb-0">{{item.name}}</h4>
              <div>Стоимость ачивки - {{ item.cost }} </div>
              <div>Автор - {{ item.author }} </div>
            </v-card-title>

            <v-card-text
              class="achievement__description"
            >
              {{item.description}}
            </v-card-text>
          </v-card>
        </v-flex>
      </v-layout>
    </v-layout>
  </v-container>
</template>

<script>
export default {
  name: 'Achievement',
  data() {
    return {
      searchQuery: '',
      achievements: [
        {
          id: 111,
          name: 'первая ачивка',
          description: 'Lorem ipsum dolor sit amet, consectetur adipisicing elit. Aliquid aperiam doloribus eveniet magni pariatur rerum unde veritatis, voluptas. A accusantium asperiores aspernatur doloribus ea eius eum incidunt neque quasi ratione.',
          cost: 58,
          author: 'OOO prot',
          icon: 'https://cdn.vuetifyjs.com/images/cards/sunshine.jpg',
          creation_date: '16 мая',
          show: false,
        },
        {
          id: 222,
          name: 'вторая ачивка',
          description: 'Lorem ipsum dolor sit amet, consectetur adipisicing elit. Aliquid aperiam doloribus eveniet magni pariatur rerum unde veritatis, voluptas. A accusantium asperiores aspernatur doloribus ea eius eum incidunt neque quasi ratione.',
          cost: 15,
          author: 'OOO prot1',
          icon: 'https://cdn.vuetifyjs.com/images/cards/sunshine.jpg',
          creation_date: 'string(unix timestamp)',
          show: false,
        },
        {
          id: 333,
          name: 'Третья ачивка',
          description: 'Lorem ipsum dolor sit amet, consectetur adipisicing elit. Aliquid aperiam doloribus eveniet magni pariatur rerum unde veritatis, voluptas. A accusantium asperiores aspernatur doloribus ea eius eum incidunt neque quasi ratione.',
          cost: 58,
          author: 'OOO prot2',
          icon: 'https://cdn.vuetifyjs.com/images/cards/sunshine.jpg',
          creation_date: 'string(unix timestamp)',
          show: false,
        },
        {
          id: 444,
          name: '4 ачивка',
          description: 'Lorem ipsum dolor sit amet, consectetur adipisicing elit. Aliquid aperiam doloribus eveniet magni pariatur rerum unde veritatis, voluptas. A accusantium asperiores aspernatur doloribus ea eius eum incidunt neque quasi ratione.',
          cost: 58,
          author: 'OOO prot',
          icon: 'https://cdn.vuetifyjs.com/images/cards/sunshine.jpg',
          creation_date: '16 мая',
          show: false,
        },
        {
          id: 555,
          name: '5 ачивка',
          description: 'Lorem ipsum dolor sit amet, consectetur adipisicing elit. Aliquid aperiam doloribus eveniet magni pariatur rerum unde veritatis, voluptas. A accusantium asperiores aspernatur doloribus ea eius eum incidunt neque quasi ratione.',
          cost: 15,
          author: 'OOO prot1',
          icon: 'https://cdn.vuetifyjs.com/images/cards/sunshine.jpg',
          creation_date: 'string(unix timestamp)',
          show: false,
        },
        {
          id: 666,
          name: 'шестая ачивка',
          description: 'Lorem ipsum dolor sit amet, consectetur adipisicing elit. Aliquid aperiam doloribus eveniet magni pariatur rerum unde veritatis, voluptas. A accusantium asperiores aspernatur doloribus ea eius eum incidunt neque quasi ratione.',
          cost: 58,
          author: 'OOO prot2',
          icon: 'https://cdn.vuetifyjs.com/images/cards/sunshine.jpg',
          creation_date: 'string(unix timestamp)',
          show: false,
        },
      ],
    };
  },
  computed: {
    filteredAchievements() {
      let { achievements, searchQuery } = this;
      searchQuery = searchQuery.toLowerCase();

      if (searchQuery) {
        achievements = achievements
          .filter(item =>
            item.name.toLowerCase().indexOf(searchQuery) > -1
            || item.author.toLowerCase().indexOf(searchQuery) > -1
          );
      }

      return achievements;
    },
  },
};
</script>

<style lang="scss" scoped>
  .achievement {
    max-width: 1200px;

    &__container {

    }
    &__title {
      display: flex;
      flex-direction: column;
      align-items: flex-start;
    }
    &__img {
      min-height: 200px;
    }
    &__item {
      max-width: 20%;
      padding: 0 10px 20px;

      @media (max-width: 1000px) {
        max-width: 30%;
      }
      @media (max-width: 720px) {
        padding: 0 0 20px;
        flex-basis: 100%;
        max-width: 100%!important;
      }
    }
    &__description {
      text-align: justify;
    }
  }
</style>
