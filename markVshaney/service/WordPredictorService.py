import random


class WordPredictorService:
    """ Abstract class for a service that predicts the next word in a sentence """

    def predict(self, input_text, output_length) -> str:
        """ Predict the next word in a sentence """
        pass


class BasicMarkovChainWordPredictor(WordPredictorService):
    """ Predict the next word in a sentence using a Markov Chain """

    def predict(self, input_text, output_length) -> str:
        ngram_store = self.generate_ngram(input_text, 2)
        random_int = random.randint(0, len(input_text) - 1)

        random_start_key = (input_text[random_int], input_text[random_int + 1])
        roll_predict = self.markov_chain_word_generate(random_start_key, output_length, ngram_store)
        return " ".join(roll_predict)


    def markov_chain_word_generate(self, current_key, output_size, ngram_store, generated_text = []):
        if output_size == 0:
            return generated_text
        else:
            next_word = self.predict_next_word(current_key, ngram_store)
            generated_text.append(next_word)
            new_key = (current_key[1], next_word)
            return self.markov_chain_word_generate(new_key, output_size - 1, ngram_store, generated_text)


    def predict_next_word(self, key: tuple, ngram_store: dict) -> str:
        return self.random_word(ngram_store[key])

    def random_word(self, input_text: list[str]) -> str:
        return input_text[random.randint(0, len(input_text) - 1)]

    def generate_ngram(self, text: list[str], n_size: int) -> dict:
        store = dict()

        for i in range(len(text) - n_size):
            key = tuple(text[i:i + n_size])
            value = text[i + n_size]

            if key in store:
                store[key].append(value)
            else:
                store[key] = [value]
        return store

