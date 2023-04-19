User u1 = new User("user1")
Bot bot = new Bot()
bot
Bot bot = new Bot()
bot
u1.join(bot)

bot = u1.join(bot)
bot = new User("user2").join(bot)

bot = new Bot(List.of(u1, new User("user2")))
bot = new User("user3").join(bot)

Bot bot1 = u1.join(new Bot())
new User("user4").join(bot)
new User("user5").join(bot1)