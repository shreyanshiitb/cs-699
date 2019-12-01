import pandas as pd
import sys
import matplotlib.pyplot as plt

bandits = pd.read_csv(sys.argv[2])
plotCount = 0
instances = bandits.groupby('instance')
for instance,i_val in instances:
    plt.xscale('log')
    plt.yscale('log')
    plt.xlabel('Horizon(log scale)')
    plt.ylabel('Regret(log scale)')
    plt.title('Instance '+instance)

    algorithms = i_val.groupby('algorithm')
    for algorithm,a_val in algorithms:
        if algorithm == 'epsilon-greedy':
            epsilons = a_val.groupby('epsilon')
            for epsilon,e_val in epsilons:
                plt.plot(e_val.groupby('horizon')['REG'].mean(),label=algorithm+str(epsilon))
        else:
            plt.plot(a_val.groupby('horizon')['REG'].mean(),label=algorithm)
    plt.legend()
    plotCount+=1
    filename = 'instance'+str(plotCount)+'.png'
    plt.savefig(filename)
    plt.show()
