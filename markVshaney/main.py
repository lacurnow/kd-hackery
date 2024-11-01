from data.TrainingTextDAO import LocalTrainingText
from service.WordPredictorService import BasicMarkovChainWordPredictor


def makeShaneyTalk(wordCount):
    trainingText = LocalTrainingText().clean_training_text("training_text.txt")
    print(BasicMarkovChainWordPredictor().predict(trainingText, wordCount))

if __name__ == '__main__':
    makeShaneyTalk(50)
