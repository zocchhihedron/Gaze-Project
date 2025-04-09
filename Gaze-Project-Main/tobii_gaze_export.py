#Remember to use Python 3.10
import sys
print(sys.executable)
import tobii_research as tr
import time
import json

found_eyetrackers = tr.find_all_eyetrackers()
my_eyetracker = found_eyetrackers[0]

gaze_sample_list = []

#Gaze data collection
def gaze_data_callback(gaze_data):
    # Print gaze points of left and right eye
    gaze_left_eye=gaze_data['left_gaze_point_on_display_area']
    gaze_right_eye=gaze_data['right_gaze_point_on_display_area']

    #Current time for obtaining time in between gaze changes
    time_sample = time.time()

    #Momentary data with each sample
    gaze_sample = {
        "time" : time_sample,
        "gaze_left_eye" : gaze_left_eye,  
        "gaze_right_eye" : gaze_right_eye 
    }
    gaze_sample_list.append(gaze_sample)


#Subscription to the gaze data through a callback function, which
#gets called every time there is a new gaze data sample
my_eyetracker.subscribe_to(tr.EYETRACKER_GAZE_DATA, gaze_data_callback, as_dictionary=True)


#Collect data for n seconds and unsubscribe from the callback function afterwards 
time.sleep(5)
my_eyetracker.unsubscribe_from(tr.EYETRACKER_GAZE_DATA, gaze_data_callback)

#Modify the time value in gaze samples to represent time range for each sample
for i in range(len(gaze_sample_list) -1):
    current_sample = gaze_sample_list[i]
    following_sample = gaze_sample_list[i+1]
    current_sample["time"] = following_sample["time"] - current_sample["time"]

#Define a time range for the time range of the last sample
gaze_sample_list[-1]["time"] = 1 #Placeholder

#Collect to a JSON file
with open('datafile_name.json', 'w') as file:
    gaze_data_json = json.dump(gaze_sample_list, file, indent=4)
