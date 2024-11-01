import abc


class TrainingTextDAO(metaclass=abc.ABCMeta):
    """ Abstract class for extracting training text """

    @classmethod
    def __subclasshook__(cls, subclass):
        return (hasattr(subclass, 'clean_training_text') and
                callable(subclass.clean_training_text) or
                NotImplemented)

    @abc.abstractmethod
    def clean_training_text(self, path) -> str:
        """ Get the training text from the file """
        raise NotImplementedError


class LocalTrainingText(TrainingTextDAO):
    """ Extract the training text from a local file """

    def clean_training_text(self, path) -> list[str]:
        content = open(path, 'r').read().lower()
        content = content.replace("\n", " ")
        content = content.split(" ")
        return list(filter(None, content))