import uuid

class Codec:
    def __init__(self):
        self.url_map = {}
        self.tinyurl_map = {}

    def encode(self, longUrl: str) -> str:
        if longUrl not in self.url_map:
            temp = str(uuid.uuid1()).replace("-", "")
            self.url_map[longUrl] = temp
            self.tinyurl_map[temp] = longUrl

        return f"https://tinyurl.com/{self.url_map[longUrl]}"

    def decode(self, shortUrl: str) -> str:
        return self.tinyurl_map[shortUrl.split("/")[-1]]








