<template>
  <div class="achievement-page">
    <div class="filter-wrap">
      <v-text-field
        class="filter-input"
        label="Введите автора или название ачивки"
        v-model="searchQuery"
        solo
      />
      <svg class="down" xmlns="http://www.w3.org/2000/svg" version="1.1" width="100%" height="100" viewBox="0 0 100 100" preserveAspectRatio="none">
        <path d="M0 0 C 50 100 80 100 100 0 Z"></path>
      </svg>
    </div>
    <v-container>
      <h2 class="heading">Список авторов</h2>
      <v-expansion-panel expand>
        <v-expansion-panel-content
          v-for="(author, authorIndex) in filteredAuthors"
          :key="author.id"
        >
          <template v-slot:header>
            <v-avatar
              size="70px"
              color="grey lighten-4"
              class="company-avatar"
            >
              <img :src="`https://picsum.photos/500/300?image=${authorIndex * 18 + 10}`" alt="avatar">
            </v-avatar>
            <div>{{author.author_name}}</div>
          </template>
          <v-card>
            <v-card-text class="grey lighten-4">
              <v-list three-line subheader>
                <v-list-tile
                  v-for="(achievement, achievementIndex) in author.achievements"
                  :key="achievement.id"
                  avatar
                >
                  <v-list-tile-avatar>
                    <img :src="`https://picsum.photos/500/300?image=${achievementIndex * 5 + 10}`">
                  </v-list-tile-avatar>

                  <v-list-tile-content>
                    <v-list-tile-title>{{ achievement.name }} - {{ achievement.status }}</v-list-tile-title>
                    <v-list-tile-sub-title>{{ achievement.description }}</v-list-tile-sub-title>
                  </v-list-tile-content>

                  <div
                    class="achievement-cost"
                  >
                    <div class="ml-2 grey--text text--darken-2">
                      <span>{{achievement.cost}}</span>
                    </div>
                    <v-icon
                      color="yellow darken-2"
                    >
                      star
                    </v-icon>
                  </div>
                </v-list-tile>
              </v-list>
            </v-card-text>
          </v-card>
        </v-expansion-panel-content>
      </v-expansion-panel>
    </v-container>
  </div>
</template>

<script>
export default {
  name: 'Achievement',
  data() {
    return {
      searchQuery: '',
      authors: [
        {
          author_name: 'Первый автор ачивок',
          achievements: [
            {
              id: 10,
              name: 'первая ачивка',
              description: 'Lorem ipsum dolor sit amet, consectetur adipisicing elit. Aliquid aperiam doloribus eveniet magni pariatur rerum unde veritatis, voluptas. A accusantium asperiores aspernatur doloribus ea eius eum incidunt neque quasi ratione.',
              cost: 58,
              icon: 'https://cdn.vuetifyjs.com/images/cards/sunshine.jpg',
              creation_date: '16 мая',
              status: 'выполнено',
            },
            {
              id: 20,
              name: 'вторая ачивка',
              description: 'Lorem ipsum dolor sit amet, consectetur adipisicing elit. Aliquid aperiam doloribus eveniet magni pariatur rerum unde veritatis, voluptas. A accusantium asperiores aspernatur doloribus ea eius eum incidunt neque quasi ratione.',
              cost: 15,
              icon: 'https://cdn.vuetifyjs.com/images/cards/sunshine.jpg',
              creation_date: 'string(unix timestamp)',
              status: 'выполнено',
            },
            {
              id: 30,
              name: 'Третья ачивка',
              description: 'Lorem ipsum dolor sit amet, consectetur adipisicing elit. Aliquid aperiam doloribus eveniet magni pariatur rerum unde veritatis, voluptas. A accusantium asperiores aspernatur doloribus ea eius eum incidunt neque quasi ratione.',
              cost: 58,
              icon: 'https://cdn.vuetifyjs.com/images/cards/sunshine.jpg',
              creation_date: 'string(unix timestamp)',
              status: 'выполнено',
            },
            {
              id: 40,
              name: 'четвертая ачивка',
              description: 'Lorem ipsum dolor sit amet, consectetur adipisicing elit. Aliquid aperiam doloribus eveniet magni pariatur rerum unde veritatis, voluptas. A accusantium asperiores aspernatur doloribus ea eius eum incidunt neque quasi ratione.',
              cost: 58,
              icon: 'https://cdn.vuetifyjs.com/images/cards/sunshine.jpg',
              creation_date: '16 мая',
              status: 'выполнено',
            },
            {
              id: 50,
              name: 'пятая ачивка',
              description: 'Lorem ipsum dolor sit amet, consectetur adipisicing elit. Aliquid aperiam doloribus eveniet magni pariatur rerum unde veritatis, voluptas. A accusantium asperiores aspernatur doloribus ea eius eum incidunt neque quasi ratione.',
              cost: 15,
              icon: 'https://cdn.vuetifyjs.com/images/cards/sunshine.jpg',
              creation_date: 'string(unix timestamp)',
              status: 'выполнено',
            },
            {
              id: 60,
              name: 'шестая ачивка',
              description: 'Lorem ipsum dolor sit amet, consectetur adipisicing elit. Aliquid aperiam doloribus eveniet magni pariatur rerum unde veritatis, voluptas. A accusantium asperiores aspernatur doloribus ea eius eum incidunt neque quasi ratione.',
              cost: 58,
              icon: 'https://cdn.vuetifyjs.com/images/cards/sunshine.jpg',
              creation_date: 'string(unix timestamp)',
              status: 'выполнено',
            },
          ],
        },
        {
          author_name: 'Второй автор ачивок',
          achievements: [
            {
              id: 11,
              name: 'седьмая ачивка',
              description: 'Lorem ipsum dolor sit amet, consectetur adipisicing elit. Aliquid aperiam doloribus eveniet magni pariatur rerum unde veritatis, voluptas. A accusantium asperiores aspernatur doloribus ea eius eum incidunt neque quasi ratione.',
              cost: 58,
              icon: 'https://cdn.vuetifyjs.com/images/cards/sunshine.jpg',
              creation_date: '16 мая',
              status: 'выполнено',
            },
            {
              id: 21,
              name: 'восьмая ачивка',
              description: 'Lorem ipsum dolor sit amet, consectetur adipisicing elit. Aliquid aperiam doloribus eveniet magni pariatur rerum unde veritatis, voluptas. A accusantium asperiores aspernatur doloribus ea eius eum incidunt neque quasi ratione.',
              cost: 15,
              icon: 'https://cdn.vuetifyjs.com/images/cards/sunshine.jpg',
              creation_date: 'string(unix timestamp)',
              status: 'выполнено',
            },
            {
              id: 31,
              name: 'девятая ачивка',
              description: 'Lorem ipsum dolor sit amet, consectetur adipisicing elit. Aliquid aperiam doloribus eveniet magni pariatur rerum unde veritatis, voluptas. A accusantium asperiores aspernatur doloribus ea eius eum incidunt neque quasi ratione.',
              cost: 58,
              icon: 'https://cdn.vuetifyjs.com/images/cards/sunshine.jpg',
              creation_date: 'выполнено(unix timestamp)',
              status: 'выполнено',
            },
            {
              id: 41,
              name: 'десятая ачивка',
              description: 'Lorem ipsum dolor sit amet, consectetur adipisicing elit. Aliquid aperiam doloribus eveniet magni pariatur rerum unde veritatis, voluptas. A accusantium asperiores aspernatur doloribus ea eius eum incidunt neque quasi ratione.',
              cost: 58,
              icon: 'https://cdn.vuetifyjs.com/images/cards/sunshine.jpg',
              creation_date: '16 мая',
              status: 'выполнено',
            },
            {
              id: 51,
              name: 'одинадцатая ачивка',
              description: 'Lorem ipsum dolor sit amet, consectetur adipisicing elit. Aliquid aperiam doloribus eveniet magni pariatur rerum unde veritatis, voluptas. A accusantium asperiores aspernatur doloribus ea eius eum incidunt neque quasi ratione.',
              cost: 15,
              icon: 'https://cdn.vuetifyjs.com/images/cards/sunshine.jpg',
              creation_date: 'выполнено(unix timestamp)',
              status: 'выполнено',
            },
            {
              id: 61,
              name: '12 ачивка',
              description: 'Lorem ipsum dolor sit amet, consectetur adipisicing elit. Aliquid aperiam doloribus eveniet magni pariatur rerum unde veritatis, voluptas. A accusantium asperiores aspernatur doloribus ea eius eum incidunt neque quasi ratione.',
              cost: 58,
              icon: 'https://cdn.vuetifyjs.com/images/cards/sunshine.jpg',
              creation_date: 'выполнено(unix timestamp)',
              status: 'выполнено',
            },
          ],
        },
        {
          author_name: 'Третий автор ачивок',
          achievements: [
            {
              id: 1111,
              name: '13 ачивка',
              description: 'Lorem ipsum dolor sit amet, consectetur adipisicing elit. Aliquid aperiam doloribus eveniet magni pariatur rerum unde veritatis, voluptas. A accusantium asperiores aspernatur doloribus ea eius eum incidunt neque quasi ratione.',
              cost: 58,
              icon: 'https://cdn.vuetifyjs.com/images/cards/sunshine.jpg',
              creation_date: '16 мая',
              status: 'выполнено',
            },
            {
              id: 2222,
              name: 'вторая ачивка',
              description: 'Lorem ipsum dolor sit amet, consectetur adipisicing elit. Aliquid aperiam doloribus eveniet magni pariatur rerum unde veritatis, voluptas. A accusantium asperiores aspernatur doloribus ea eius eum incidunt neque quasi ratione.',
              cost: 15,
              icon: 'https://cdn.vuetifyjs.com/images/cards/sunshine.jpg',
              creation_date: 'выполнено(unix timestamp)',
              status: 'выполнено',
            },
            {
              id: 3333,
              name: 'Третья ачивка',
              description: 'Lorem ipsum dolor sit amet, consectetur adipisicing elit. Aliquid aperiam doloribus eveniet magni pariatur rerum unde veritatis, voluptas. A accusantium asperiores aspernatur doloribus ea eius eum incidunt neque quasi ratione.',
              cost: 58,
              icon: 'https://cdn.vuetifyjs.com/images/cards/sunshine.jpg',
              creation_date: 'выполнено(unix timestamp)',
              status: 'выполнено',
            },
            {
              id: 4444,
              name: '4 ачивка',
              description: 'Lorem ipsum dolor sit amet, consectetur adipisicing elit. Aliquid aperiam doloribus eveniet magni pariatur rerum unde veritatis, voluptas. A accusantium asperiores aspernatur doloribus ea eius eum incidunt neque quasi ratione.',
              cost: 58,
              icon: 'https://cdn.vuetifyjs.com/images/cards/sunshine.jpg',
              creation_date: '16 мая',
              status: 'выполнено',
            },
            {
              id: 5555,
              name: '5 ачивка',
              description: 'Lorem ipsum dolor sit amet, consectetur adipisicing elit. Aliquid aperiam doloribus eveniet magni pariatur rerum unde veritatis, voluptas. A accusantium asperiores aspernatur doloribus ea eius eum incidunt neque quasi ratione.',
              cost: 15,
              icon: 'https://cdn.vuetifyjs.com/images/cards/sunshine.jpg',
              creation_date: 'выполнено(unix timestamp)',
              status: 'выполнено',
            },
            {
              id: 6666,
              name: 'шестая ачивка',
              description: 'Lorem ipsum dolor sit amet, consectetur adipisicing elit. Aliquid aperiam doloribus eveniet magni pariatur rerum unde veritatis, voluptas. A accusantium asperiores aspernatur doloribus ea eius eum incidunt neque quasi ratione.',
              cost: 58,
              icon: 'https://cdn.vuetifyjs.com/images/cards/sunshine.jpg',
              creation_date: 'выполнено(unix timestamp)',
              status: 'выполнено',
            },
          ],
        },
        {
          author_name: 'Четвертый автор ачивок',
          achievements: [
            {
              id: 111,
              name: 'первая ачивка',
              description: 'Lorem ipsum dolor sit amet, consectetur adipisicing elit. Aliquid aperiam doloribus eveniet magni pariatur rerum unde veritatis, voluptas. A accusantium asperiores aspernatur doloribus ea eius eum incidunt neque quasi ratione.',
              cost: 58,
              icon: 'https://cdn.vuetifyjs.com/images/cards/sunshine.jpg',
              creation_date: '16 мая',
              status: 'выполнено',
            },
            {
              id: 222,
              name: 'вторая ачивка',
              description: 'Lorem ipsum dolor sit amet, consectetur adipisicing elit. Aliquid aperiam doloribus eveniet magni pariatur rerum unde veritatis, voluptas. A accusantium asperiores aspernatur doloribus ea eius eum incidunt neque quasi ratione.',
              cost: 15,
              icon: 'https://cdn.vuetifyjs.com/images/cards/sunshine.jpg',
              creation_date: 'выполнено(unix timestamp)',
              status: 'выполнено',
            },
            {
              id: 333,
              name: 'Третья ачивка',
              description: 'Lorem ipsum dolor sit amet, consectetur adipisicing elit. Aliquid aperiam doloribus eveniet magni pariatur rerum unde veritatis, voluptas. A accusantium asperiores aspernatur doloribus ea eius eum incidunt neque quasi ratione.',
              cost: 58,
              icon: 'https://cdn.vuetifyjs.com/images/cards/sunshine.jpg',
              creation_date: 'выполнено(unix timestamp)',
              status: 'выполнено',
            },
            {
              id: 444,
              name: '4 ачивка',
              description: 'Lorem ipsum dolor sit amet, consectetur adipisicing elit. Aliquid aperiam doloribus eveniet magni pariatur rerum unde veritatis, voluptas. A accusantium asperiores aspernatur doloribus ea eius eum incidunt neque quasi ratione.',
              cost: 58,
              icon: 'https://cdn.vuetifyjs.com/images/cards/sunshine.jpg',
              creation_date: '16 мая',
              status: 'выполнено',
            },
            {
              id: 555,
              name: '5 ачивка',
              description: 'Lorem ipsum dolor sit amet, consectetur adipisicing elit. Aliquid aperiam doloribus eveniet magni pariatur rerum unde veritatis, voluptas. A accusantium asperiores aspernatur doloribus ea eius eum incidunt neque quasi ratione.',
              cost: 15,
              icon: 'https://cdn.vuetifyjs.com/images/cards/sunshine.jpg',
              creation_date: 'выполнено(unix timestamp)',
              status: 'выполнено',
            },
            {
              id: 666,
              name: 'шестая ачивка',
              description: 'Lorem ipsum dolor sit amet, consectetur adipisicing elit. Aliquid aperiam doloribus eveniet magni pariatur rerum unde veritatis, voluptas. A accusantium asperiores aspernatur doloribus ea eius eum incidunt neque quasi ratione.',
              cost: 58,
              icon: 'https://cdn.vuetifyjs.com/images/cards/sunshine.jpg',
              creation_date: 'выполнено(unix timestamp)',
              status: 'выполнено',
            },
          ],
        },
      ],
    };
  },
  computed: {
    filteredAuthors() {
      let { authors, searchQuery } = this;
      searchQuery = searchQuery.toLowerCase();

      if (searchQuery) {
        authors = authors
          .filter((author) => {
            const authorValue = author.author_name.toLowerCase().indexOf(searchQuery) > -1;
            const achievementValue = this.filteredAchievements(author.achievements);

            return authorValue || achievementValue;
          });
      }

      return authors;
    },
  },
  methods: {
    filteredAchievements(achievements) {
      let { searchQuery } = this;
      let filteredAchievements = achievements;
      searchQuery = searchQuery.toLowerCase();

      if (searchQuery) {
        filteredAchievements = filteredAchievements
          .filter(item => item.name.toLowerCase().indexOf(searchQuery) > -1);
      }

      return filteredAchievements.length !== 0;
    },
  }
};
</script>

<style lang="scss" scoped>
  $primary-color: #6B54E7;

  .company-avatar {
    max-width: 70px;
    margin-right: 20px;
  }

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

    @media screen and (max-width: 768px) {
      padding: 65px 30px 0;
    }
  }

  .filter-input {
    width: 100%;
    max-width: 1024px;
    margin: auto!important;
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
  .achievement-cost {
    display: flex;
    align-items: center;
  }
  .heading {
    margin: 0 0 30px;
    font-size: 32px;
    line-height: 1.5;
    font-weight: bold;
    text-align: left;
  }
</style>
