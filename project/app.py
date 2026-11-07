
from http.server import BaseHTTPRequestHandler, HTTPServer

class DockerDemoHandler(BaseHTTPRequestHandler):
    def do_GET(self):
        message = """
        <h1>Docker Hub, Containers and Docker Images</h1>
        <p>The application is running inside a Docker container.</p>
        <p>This page demonstrates containerized deployment.</p>
        """
        self.send_response(200)
        self.send_header("Content-Type", "text/html")
        self.end_headers()
        self.wfile.write(message.encode())

server = HTTPServer(("0.0.0.0", 8000), DockerDemoHandler)

print("Docker demo running on port 8000")

try:
    server.serve_forever()
except KeyboardInterrupt:
    print("Server stopped")
finally:
    server.server_close()
