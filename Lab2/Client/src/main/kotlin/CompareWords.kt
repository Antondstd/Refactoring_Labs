import Models.WordModel

class CompareWords {
    companion object: Comparator<WordModel>{
        override fun compare(wordModel1: WordModel, wordModel2: WordModel): Int {
            return wordModel1.getAmountOfParts() - wordModel2.getAmountOfParts()
        }

    }
}