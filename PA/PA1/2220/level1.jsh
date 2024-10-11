Task t = new Task(1, 12, 14, "lunch with boss")
t.edit(13, 14)
t
t = t.edit(13, 14)
t.cancel()
t.cancel().edit(12, 14)
t.cancel().cancel()