from confluent_kafka.admin import AdminClient, NewTopic
import asyncio
from confluent_kafka import Consumer, Producer
import base64
import json
import os
import time
BROKER_URL = "localhost:9092"
TOPIC_NAME = "image.nocompression"

global time_executing 
time_executing = []


def benchmarking(exctimes):
    for i in range(0,exctimes):
        try:
            asyncio.run(produce(TOPIC_NAME))
        except KeyboardInterrupt as e:
            print("shutting down")
    result = sum(time_executing) / exctimes
    print(f"avg throughput = {result}")



async def produce(topic_name):
    #See: https://github.com/edenhill/librdkafka/blob/master/CONFIGURATION.md
    p = Producer({   
        "bootstrap.servers":BROKER_URL,
        "client.id": "person.web",
        "batch.num.messages": "100",
        })

    directory = os.getcwd() + u'\\Compression'
    start_time = time.time()
    for filename in os.listdir(directory):
            imagefile = os.path.join(directory, filename)
            p.produce(topic_name, serializer_image(imagefile))
            #print(f"Time elapsed {end_time-start_time}")
            await asyncio.sleep(1.0)
    end_time = time.time()
    time_executing.append(end_time-start_time)



def serializer_image(imagefile):
    with open(imagefile, "rb") as image_file:
        encoded_string = base64.b64encode(image_file.read())
    return json.dumps(encoded_string.decode("utf-8"))

def main():

    try:
        asyncio.run(produce(TOPIC_NAME))
    except KeyboardInterrupt as e:
        print("shutting down")


if __name__ == "__main__":
    benchmarking(5)