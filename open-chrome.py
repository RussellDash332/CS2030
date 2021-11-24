import sys
import webbrowser

try:
    print("Opening...")
    webbrowser.open(sys.argv[1])
    sys.exit(0)
except:
    print("Cannot find the file specified...")
    sys.exit(1)
