print('start')

try:
  raise Exception('an exception occured.')
except Exception as e:
  print('Exception occured. {}: {}'.format(e.__class__.__name__, e))
  a = 1/0

print('end')
