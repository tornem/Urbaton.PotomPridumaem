<template>
  <div class="achievement-page">
    <div class="filter-wrap">
      <v-text-field
        class="filter-input"
        label="Введите название ачивки"
        v-model="searchQuery"
        solo
      />
      <svg class="down" xmlns="http://www.w3.org/2000/svg" version="1.1" width="100%" height="100" viewBox="0 0 100 100" preserveAspectRatio="none">
        <path d="M0 0 C 50 100 80 100 100 0 Z"></path>
      </svg>
    </div>
    <v-container>
      <v-layout
        row
        wrap
        justify-flex-start
        class="container"
      >
        <v-flex
          v-for="(item, i) in filteredAchievements"
          :key="item.id"
          class="item"
          xs6
        >
          <v-card>
            <!--<v-img-->
            <!--:src="item.icon"-->
            <!--class="img"-->
            <!--aspect-ratio="2.75"-->
            <!--&gt;</v-img>-->
            <v-img
              :src="`https://picsum.photos/500/300?image=${i * 11 + 10}`"
              class="img"
              aspect-ratio="2.75"
            />

            <v-card-title class="title">
              <h4 class="headline mb-0">{{item.name}}</h4>
              <div>Стоимость ачивки - {{ item.cost }} </div>
              <div>Автор - {{ item.author }} </div>
            </v-card-title>

            <v-card-text class="description">
              {{item.description}}
            </v-card-text>
          </v-card>
        </v-flex>
    </v-layout>
    </v-container>
  </div>
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
  $primary-color: #6B54E7;

  .achievement-page {
    width: 100%;
  }

  .filter-wrap {
    position: relative;
    width:100%;
    padding: 95px 30px 0;
    margin-bottom: 100px;
    background-color: $primary-color;

    svg {
      position: absolute;
      left: 0;
      right: 0;
      bottom: -100px;
      margin:  auto;
      fill: $primary-color;
    }
  }

  .filter-input {
    width: 100%;
    max-width: 1024px;
    margin: auto;
  }

  .title {
    display: flex;
    flex-direction: column;
    align-items: flex-start;
  }

  .img {
    min-height: 200px;
  }

  .item {
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

  .description {
    text-align: justify;
  }
</style>
