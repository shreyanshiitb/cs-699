import matplotlib.pyplot as plt
import numpy as np
import warnings
warnings.simplefilter("ignore")

encoded = np.load('message.npy')
c = np.min(encoded)
d = np.max(encoded)
encoded = (encoded-c)*(255/(d-c))
plt.imshow(encoded.astype(int))
plt.savefig('processedimage.png')
# d23ffe8fffdc9cd149dfe31ae1418b30
