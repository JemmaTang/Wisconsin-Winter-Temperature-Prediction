# Wisconsin-Winter-Temperature-Prediction
Based on the history data of ice days in the winter, I developed a model to predict how harsh this Wisconsin winter will be.
The Wisconsin State Climatology Office keeps a record on the number of days Lake Mendota was covered
by ice at http://www.aos.wisc.edu/~sco/lakes/Mendota-ice.html.

1. As with any real problems, the data is not as clean or as organized as one would like for machine learning. Curate a clean data set starting from 1855-56 and ending in 2017-18. Let x be the year: for 1855-56, x = 1855; for 2017-18, x = 2017; and so on. Let y be the ice days in that year: for 1855-56, y = 118; for 2017-18, y = 94; and so on. Some years have multiple freeze thaw cycles such as 2001-02, that one should be x = 2001, y = 21. 

2. Computed β1 and β0 for different models (ordinary least regression, gradient descent, stochastic gradient descent). Since n is small in our data set, there is little advantage of SGD over gradient descent. However, on large data sets SGD becomes more desirable.
