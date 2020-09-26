from flask import Flask, render_template, request
import pandas
""" most useless flask tutorial i've ever seen """


def quick_sort(lis):
    # print(lis)
    j = -1
    i = 0
    for i in range(len(lis)):
        if lis[i] <= lis[len(lis) - 1]:
            j += 1
            lis[i], lis[j] = lis[j], lis[i]
    if j != i and j >= 0:
        lis[j + 1], lis[len(lis) - 1] = lis[len(lis) - 1], lis[j + 1]
        # print(lis)
        left = quick_sort(lis[:j])
        right = quick_sort(lis[j:])
        lis = left + right
    # print(lis)
    return lis


app = Flask(__name__)


@app.route("/sort.html")
def result():
    return render_template('sort.html')


@app.route('/index.html')
def index():
    return render_template('index.html')


@app.route('/')
def go():
    filename = 'program.csv'
    with open(filename, 'w') as file_object:
        file_object.write('name')
        file_object.write(',')
        file_object.write('email')
        file_object.write(',')
        file_object.write('answer')
        file_object.write("\n")
    return render_template('index.html')


@app.route('/answer', methods=['POST'])
def nn():
    name = request.form['name']
    email = request.form['email']
    answer = request.form['message']
    filename = 'program.csv'
    with open(filename, 'a') as file_object:
        file_object.write(name)
        file_object.write(',')
        file_object.write(email)
        file_object.write(',')
        file_object.write(answer)
        file_object.write("\n")
    return render_template('index.html')


@app.route('/answer2', methods=['POST'])
def sort_sting():
    string = list(map(int,request.form['string'].split()))
    string = quick_sort(string)
    string = " ".join(map(str,string))
    return render_template('/sort.html', ans=string)


@app.route('/answer3', methods=['POST'])
def find_sting():
    name1 = request.form['name1']
    f = pandas.read_csv('program.csv')
    answer2 = f[f['name'] == name1].values
    return render_template('/result.html', ans2=answer2)


if __name__ == '__main__':
    app.run(debug=True)
