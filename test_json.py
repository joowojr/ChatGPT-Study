from openai import OpenAI
from config import *
client = OpenAI(
    api_key= OPENAI_API_KEY
)

completion = client.chat.completions.create(
  model="gpt-3.5-turbo-1106",
  messages=[
    {"role": "system", "content": "You are a helpful assistant."},
    {"role": "user", "content": "봄에 대한 시를 써줘. json"}
  ],
  response_format={"type" : "json_object"}
)

print(completion.choices[0].message.content)

